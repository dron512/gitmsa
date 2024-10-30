import { useRouter } from "expo-router";
import React, { useState } from "react";
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  TouchableOpacity,
  Image,
} from "react-native";

const LoginScreen = () => {
  const kakaoUri = require("../../assets/images/kakao.png");
  const router = useRouter();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    // 로그인 로직을 처리하는 부분 (예: API 호출)
    console.log("Username:", username);
    console.log("Password:", password);
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>로그인</Text>
      <TextInput
        style={styles.input}
        placeholder="사용자 이름"
        value={username}
        onChangeText={setUsername}
      />
      <TextInput
        style={styles.input}
        placeholder="비밀번호"
        value={password}
        onChangeText={setPassword}
        secureTextEntry // 비밀번호 입력 시 텍스트를 숨김
      />
      <TouchableOpacity style={styles.button} onPress={handleLogin}>
        <Text style={styles.buttonText}>로그인</Text>
      </TouchableOpacity>
      <TouchableOpacity
        style={styles.button}
        onPress={() => {
          router.push("/login/join");
        }}
      >
        <Text style={styles.buttonText}>회원가입</Text>
      </TouchableOpacity>
      <TouchableOpacity>
        <Text style={styles.link}>비밀번호를 잊으셨나요?</Text>
      </TouchableOpacity>
      <TouchableOpacity
        style={{ flexDirection: "row", marginTop: 10 }}
        onPress={() => router.push("/login/kakaoLogin")}
      >
        <Image
          style={{ margin: 5 }}
          source={require("../../assets/images/naver.png")} // 파일 경로에 맞게 수정
        />
        <Image
          style={{ margin: 5 }}
          source={require("../../assets/images/kakao.png")} // 파일 경로에 맞게 수정
        />
        <Image
          style={{ margin: 5 }}
          source={require("../../assets/images/google.png")} // 파일 경로에 맞게 수정
        />
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    padding: 20,
    backgroundColor: "#f0f0f0",
  },
  title: {
    fontSize: 28,
    fontWeight: "bold",
    marginBottom: 20,
  },
  input: {
    width: "100%",
    height: 50,
    borderColor: "#ccc",
    borderWidth: 1,
    borderRadius: 8,
    paddingHorizontal: 10,
    marginBottom: 15,
    backgroundColor: "#fff",
  },
  kakaoButton: {
    marginVertical: 10,
    backgroundColor: "#990033", // 버튼 색상
    paddingVertical: 15,
    paddingHorizontal: 20,
    borderRadius: 8,
    width: "100%",
    alignItems: "center",
  },
  button: {
    marginVertical: 10,
    backgroundColor: "#007BFF", // 버튼 색상
    paddingVertical: 15,
    paddingHorizontal: 20,
    borderRadius: 8,
    width: "100%",
    alignItems: "center",
  },
  buttonText: {
    color: "#fff", // 버튼 텍스트 색상
    fontSize: 18,
    fontWeight: "bold",
  },
  link: {
    marginTop: 15,
    color: "#007BFF",
    textDecorationLine: "underline", // 링크 스타일
  },
});

export default LoginScreen;
