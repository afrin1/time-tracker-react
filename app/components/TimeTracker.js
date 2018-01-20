import React, { Component } from 'react';
import {
  StyleSheet,
  Text,
  View,
  NativeModules
} from 'react-native';
// import UsageStats from './UsageStats';
// import { NativeModules } from 'react-native';

var usageStats = NativeModules.UsageStats;
var uri;
var error;

export default class TimeTracker extends Component {

  constructor(props) {
   super(props);
   this.state = {muri: ''};
 }

  componentDidMount(){
    usageStats.openSelectDialog(
      (uri) => { this.setState(() => {
        return { muri: uri};
      });
        console.log(this.state.muri) },
      (error) => { console.log(error) }
    );
    console.log("uri - "+this.state.muri);
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
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
  }
});
