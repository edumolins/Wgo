package wgo_app.wgo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.imanoweb.calendarview.CustomCalendarView;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemoActivity extends AppCompatActivity {

    CustomCalendarView calendarView;
    CaldroidFragment caldroidFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_demo_main);

        caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
        args.putBoolean(CaldroidFragment.SHOW_NAVIGATION_ARROWS, true);
        //caldroidFragment.setShowNavigationArrows(false);
        //caldroidFragment.setEnableSwipe(false);


        //args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);
        caldroidFragment.setArguments(args);
        caldroidFragment.refreshView();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, caldroidFragment);
        t.commit();

        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                ColorDrawable green = new ColorDrawable(Color.GREEN);
                caldroidFragment.setBackgroundDrawableForDate(green, date);
                caldroidFragment.refreshView();
            }

            @Override
            public void onChangeMonth(int month, int year) {
                String text = "month: " + month + " year: " + year;
                Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickDate(Date date, View view) {
                Toast.makeText(getApplicationContext(),
                        "Long click ",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCaldroidViewCreated() {
                Toast.makeText(getApplicationContext(),
                        "Caldroid view is created",
                        Toast.LENGTH_SHORT).show();
            }

        };

        caldroidFragment.setCaldroidListener(listener);
  /*      calendarView = (CustomCalendarView) findViewById(R.id.calendar_view);

        //Initialize calendar with date
                Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        //Show Monday as first date of week
                calendarView.setFirstDayOfWeek(Calendar.MONDAY);

            //Show/hide overflow days of a month
                //calendarView.setShowOverflowDate(false);
                calendarView.setShowOverflowDate(true);
        //call refreshCalendar to update calendar the view
                calendarView.refreshCalendar(currentCalendar);

        //Handling custom calendar events
                calendarView.setCalendarListener(new CalendarListener() {
                    @Override
                    public void onDateSelected(Date date) {
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        Toast.makeText(CalendarDemoActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
                        //calendarView.selec
                    }

                    @Override
                    public void onMonthChanged(Date date) {
                        SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
                        Toast.makeText(CalendarDemoActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
                    }
                });*/


            }


}

