import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View , Pressable, TouchableOpacity, Alert, Linking} from 'react-native';

export default function App() {

  const doPerss1 = () => {
    Alert.alert('doPress1');
    console.log("test111");
  };
  const doPerss2 = () => {
    Alert.alert('doPress2');
    console.log("test22");
  };

  return (
    <View style={styles.container}>
      <Text style={styles.text}>Open up App.js to start working on your app!</Text>
      <Text style={styles.text}>This is a simple React Native app.</Text>
      <Text style={styles.text}>To run this app, follow these steps:</Text>
      <TouchableOpacity style={styles.button} onPress={doPerss1}>
        <Text style={styles.text}>누르는버튼</Text>
      </TouchableOpacity>
      <TouchableOpacity style={styles.button} onPress={doKakao}>
        <Text style={styles.text}>카카오로그인</Text>
      </TouchableOpacity>
      <Pressable style={styles.button} onPress={doPerss2}>
        <Text style={styles.text}>누르는버튼</Text>
      </Pressable>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#999',
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    fontSize: 24,
    color: 'white',
  },
  button:{
    backgroundColor: 'blue',
    padding: 10,
    borderRadius: 5,
    color: 'white',
    marginTop: 10,
  }
});
