package com.squareup.timessquare;

import android.view.ContextThemeWrapper;

public class DefaultDayViewAdapter implements DayViewAdapter {
  @Override
  public void makeCellView(CalendarCellView parent) {
      GNBookTextView textView = new GNBookTextView(
              new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_CalendarDate));
      textView.setDuplicateParentStateEnabled(true);
      parent.addView(textView);
      parent.setDayOfMonthTextView(textView);
  }
}
