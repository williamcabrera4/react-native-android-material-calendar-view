package com.material_calendarview;

import android.support.annotation.NonNull;
import android.view.View;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;
import java.util.Date;

import static java.security.AccessController.getContext;

public class MaterialCalendarViewManager extends SimpleViewManager<MaterialCalendarView> {

    public static final String REACT_CLASS = "MaterialCalendarView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected MaterialCalendarView createViewInstance(ThemedReactContext reactContext) {
        MaterialCalendarView materialCalendarView = new MaterialCalendarView(reactContext);
        materialCalendarView.setSelectedDate(new Date());
        onReceiveNativeEvent(reactContext, materialCalendarView);
        return materialCalendarView;
    }

    public void onReceiveNativeEvent(final ThemedReactContext reactContext, final MaterialCalendarView materialCalendarView) {
        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                WritableMap event = Arguments.createMap();
                event.putString("date", date.getDate().toString());
                event.putInt("day", date.getDay());
                event.putInt("month", date.getMonth());
                event.putInt("year", date.getYear());
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(materialCalendarView.getId(), "topChange", event);
            }
        });
    }

    @ReactProp(name = "day")
    public void setDay(MaterialCalendarView view, int day) {
        Calendar cal = view.getSelectedDate().getCalendar();
        cal.set(Calendar.DAY_OF_MONTH, day);
        Date dateRepresentation = cal.getTime();
        view.setSelectedDate(dateRepresentation);
    }

    @ReactProp(name = "month")
    public void setMonth(MaterialCalendarView view, int month) {
        Calendar cal = view.getSelectedDate().getCalendar();
        cal.set(Calendar.MONTH, month - 1);
        Date dateRepresentation = cal.getTime();
        view.setSelectedDate(dateRepresentation);
    }

    @ReactProp(name = "year")
    public void setYear(MaterialCalendarView view, int year) {
        Calendar cal = view.getSelectedDate().getCalendar();
        cal.set(Calendar.YEAR, year);
        Date dateRepresentation = cal.getTime();
        view.setSelectedDate(dateRepresentation);
    }
}