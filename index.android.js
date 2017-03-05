/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
} from 'react-native';
import MaterialCalendarView from './android-native-component/MaterialCalendarView';

export default class CalendarExample extends Component {

  constructor(props) {
    super(props);
    this.state = { dateObject: {} };
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to MaterialCalendarView
        </Text>
        <MaterialCalendarView 
          style={styles.calendarView} 
          onDateChange={(dateObject) => this.setState({ dateObject })}
          day={20} 
          month={4} 
          year={2017} 
        />
        <Text style={styles.instructions}>
          {JSON.stringify(this.state.dateObject)}
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    padding: 20,
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  calendarView: {
    width: 400,
    height: 400,
  }
});

AppRegistry.registerComponent('material_calendarview', () => CalendarExample);
