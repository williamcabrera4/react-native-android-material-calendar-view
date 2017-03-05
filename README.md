# Material CalendarView for Android using React Native
React Native module for [prolificinteractive/material-calendarview](https://github.com/prolificinteractive/material-calendarview)

![Demo](/docs/calendarView.gif)

## Example
```jsx
<MaterialCalendarView 
  style={styles.calendarView} 
  onDateChange={(dateObject) => console.log(dateObject)}
  day={20} 
  month={4} 
  year={2017} 
/>
```

## Callback object
```javascript
{
  date: "Wed Mar 15 00:00:00 AST 2017",
  day: 15,
  month: 3,
  year: 2017
}
```

## Props

- **`onDateChange`** _(Function)_ - Callback for date change
- **`day`** _(Number)_ - Set the selected day.
- **`month`** _(Number)_ - Set the selected month.
- **`year`** _(Number)_ - Set the selected year.


## Support

Please [open an issue](https://github.com/williamcabrera4/react-native-android-material-calendar-view/issues/new) for support.

## Contributing

Please contribute using [Github Flow](https://guides.github.com/introduction/flow/). Create a branch, add commits, and [open a pull request](https://github.com/williamcabrera4/chrome-app-websocket-tester/pulls).

## License
- [MIT](LICENSE)
