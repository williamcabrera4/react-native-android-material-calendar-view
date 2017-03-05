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

export default class material_calendarview extends Component {

  constructor(props) {
    super(props);
    this.state = {message: 'test'};
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to MaterialCalendarView
        </Text>
        <MaterialCalendarView 
          style={styles.calendarView} 
          onChangeMessage={(message) => this.setState({message})}
          day={20} 
          month={4} 
          year={2017} 
        />
        <Text style={styles.instructions}>
          {JSON.stringify(this.state.message)}
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
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  calendarView: {
    width: 400,
    height: 400,
  }
});

AppRegistry.registerComponent('material_calendarview', () => material_calendarview);
