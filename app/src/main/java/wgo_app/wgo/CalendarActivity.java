package wgo_app.wgo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

import wgo_app.wgo.fonts.CustomButton;
import wgo_app.wgo.utils.Constants;

public class CalendarActivity extends Activity {

    private  CalendarPickerView calendar;
    //private  TextView numberWeekends;
    private CustomButton buttonAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_main);



        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        CalendarPickerView.numberWeekends = (TextView)findViewById(R.id.num_weekends);
        buttonAccept = (CustomButton)findViewById(R.id.button_accept);

        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.numWeekends = calendar.getSelectedDates().size() / 3;
                Constants.fromCalendar = true;
                finish();
            }
        });
        Calendar today = Calendar.getInstance();

        today.set(Calendar.DAY_OF_MONTH,
                today.getActualMaximum(Calendar.DAY_OF_MONTH));

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        calendar.init(new Date(),nextYear.getTime()) //
                .inMode(CalendarPickerView.SelectionMode.MULTIPLE);

        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {

                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                int diff = 7 - dayOfWeek;

                //It's sunday
                if (diff == 6) {
                    diff = -1;
                }
                //c.clear();
                c.add(Calendar.DATE, diff);
                Date saturday = c.getTime();
                c.clear();

                c.setTime(date);
                c.add(Calendar.DATE, diff - 1);
                Date before = c.getTime();
                c.clear();

                c.setTime(date);
                c.add(Calendar.DATE, diff + 1);
                Date next = c.getTime();
                c.clear();

                calendar.selectDate(before);
                calendar.selectDate(next);
                calendar.selectDate(saturday);

                if (dayOfWeek == 7)
                    calendar.selectDate(saturday);
                else if (dayOfWeek == 6)
                    calendar.selectDate(before);
                else if (dayOfWeek == 1)
                    calendar.selectDate(next);
                else if (dayOfWeek < 6 && dayOfWeek > 1)
                    calendar.selectDate(date);

                CalendarPickerView.numberWeekends.setText(Integer.toString(calendar.getSelectedDates().size() / 3));


            }

            @Override
            public void onDateUnselected(Date date) {
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                int diff = 7 - dayOfWeek;

                if (diff == 6) {
                    diff = -1;
                }
                //c.clear();
                c.add(Calendar.DATE, diff);
                Date saturday = c.getTime();
                c.clear();

                c.setTime(date);
                c.add(Calendar.DATE, diff - 1);
                Date before = c.getTime();
                c.clear();

                c.setTime(date);
                c.add(Calendar.DATE, diff + 1);
                Date next = c.getTime();
                c.clear();

                calendar.selectDate(before);
                calendar.selectDate(next);
                calendar.selectDate(saturday);
                calendar.selectDate(date);

                CalendarPickerView.numberWeekends.setText(Integer.toString(calendar.getSelectedDates().size() / 3));

            }
        });
        RelativeLayout close = (RelativeLayout)findViewById(R.id.close_layout);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        CalendarPickerView.numberWeekends.setText(Integer.toString(calendar.getSelectedDates().size() / 3));
    }

}

