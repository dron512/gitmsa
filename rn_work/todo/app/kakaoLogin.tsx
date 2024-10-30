import { useRouter } from "expo-router";
import React, { useState } from "react";
import { View, StyleSheet, Text } from "react-native";
import { WebView } from "react-native-webview";
import AsyncStorage from "@react-native-async-storage/async-storage";

const REST_API_KEY = "477ea0788a39a67ac40fa6b1bc49e7d8";
const REDIRECT_URI = "http://back.hellomh.site/oauth/kakao/callback";
const INJECTED_JAVASCRIPT = `
  (function() {
    const bodyContent = document.body.innerHTML;
    window.ReactNativeWebView.postMessage(bodyContent);
  })();
  true; // Required for Android
`;

const KaKaoLogin = () => {
  const [bodyContent, setBodyContent] = useState("");
  const router = useRouter();

  const handleWebViewMessage = async (event: any) => {
    const data = event.nativeEvent.data; // WebView에서 보낸 데이터
    console.log("Body content received:", data); // 가져온 내용 로그 출력
    await AsyncStorage.setItem("token", data);

    // setBodyContent(data); // 상태 업데이트
    // router.push('/(tabs)');
  };

  //   const handleWebViewMessage = async (event: any) => {

  //     console.log(event.nativeEvent.data);
  //     const data = event.nativeEvent.data;
  //     try {
  //         await AsyncStorage.setItem('token', data);

  //         // 저장값 확인을 위한 console.log
  //         console.log(`setItem... : ${data}`);
  //     } catch (error) {
  //       console.error("Failed to save data", error);
  //     }
  //     const token: any = await AsyncStorage.getItem("token");
  //     setBodyContent(token); // 가져온 내용을 상태로 업데이트
  //     //   router.push('/(tabs)');
  //   };

  return (
    <View style={Styles.container}>
      <Text>{bodyContent}</Text>
      <WebView
        style={{ flex: 1 }}
        originWhitelist={["*"]}
        scalesPageToFit={false}
        source={{
          uri: `https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}`,
        }}
        injectedJavaScript={INJECTED_JAVASCRIPT}
        javaScriptEnabled
        onMessage={handleWebViewMessage}
      />
    </View>
  );
};

export default KaKaoLogin;

const Styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: 24,
    backgroundColor: "#fff",
  },
});
