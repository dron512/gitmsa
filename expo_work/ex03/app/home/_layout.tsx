import { Slot } from "expo-router";
import { View, Text } from "react-native";

function Header() {
  return (
    <View>
      <Text>Header</Text>
    </View>
  );
}
export default function Home(){
  return (
    <View>
      <Header></Header>
      <Slot></Slot>
    </View>
  )
};