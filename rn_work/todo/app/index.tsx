import axios from "axios";
import { Link, router, useRouter } from "expo-router";
import { Button, StyleSheet, Text, View } from "react-native";
import * as KakaoLogins from "@react-native-seoul/kakao-login";

const Index = () => {
  const router = useRouter();
  return (
    <View style={styles.container}>
      <Text style={styles.title}>환영합니다!</Text>
      <View style={styles.buttonContainer}>
        <Button title="메인" onPress={()=>router.push('/(tabs)')} />
        <Button title="카카오 로그인" onPress={() => router.push('/kakaoLogin')} />
        <Button title="로그인" onPress={() => router.push('/login')} />
      </View>
    </View>
  );
};

export default Index;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#f0f0f0',
  },
  title: {
    fontSize: 24,
    marginBottom: 20,
  },
  buttonContainer: {
    width: '80%',
    justifyContent: 'space-between',
  },
});
