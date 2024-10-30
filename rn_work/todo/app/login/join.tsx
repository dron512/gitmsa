import { View,Text, StyleSheet } from "react-native";

const Join = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Join Screen</Text>
    </View>
  );
};

export default Join;

const styles = StyleSheet.create({
    container:{
        flex: 1,
        alignItems: "center",
        justifyContent: "center"
    },
    title:{
        fontSize: 20,
        marginBottom: 20,
        fontFamily:"JUA"
    }
});