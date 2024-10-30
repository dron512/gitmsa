import React from "react";
import { View, Text, StyleSheet, TouchableOpacity } from "react-native";
import { useRouter } from "expo-router";

const YourComponent = () => {
  const router = useRouter();

  return (
    <View style={styles.container}>
      <Text style={styles.title}>환영합니다!</Text>
      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.button} onPress={() => router.push('/(tabs)')}>
          <Text style={styles.buttonText}>메인</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={() => router.push('/kakaoLogin')}>
          <Text style={styles.buttonText}>카카오 로그인</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={() => router.push('/login')}>
          <Text style={styles.buttonText}>로그인</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "#fff",
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    marginBottom: 20,
  },
  buttonContainer: {
    width: "80%",
    alignItems: "center",
  },
  button: {
    backgroundColor: "#007AFF", // 버튼 색상
    borderRadius: 10, // 모서리 둥글게
    paddingVertical: 15, // 수직 패딩
    paddingHorizontal: 20, // 수평 패딩
    marginVertical: 10, // 버튼 간격
    width: "100%", // 버튼의 너비
    alignItems: "center", // 텍스트 가운데 정렬
  },
  buttonText: {
    color: "#fff", // 텍스트 색상
    fontSize: 16, // 텍스트 크기
    fontWeight: "600", // 텍스트 두께
  },
});

export default YourComponent;
