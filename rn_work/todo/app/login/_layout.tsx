import { Slot } from "expo-router";
import React from "react";
import { Text,View } from "react-native";
// import LoginScreen from ".";

function Header(){
  // Your login logic goes here
  return <Text>Header</Text>;
}

export default function TabLayout() {

  return (
    <View>
      <Header/>
      <Slot/>
    </View>
  );
}
