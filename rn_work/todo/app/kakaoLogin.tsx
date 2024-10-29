import AsyncStorage from '@react-native-async-storage/async-storage';
import axios from 'axios';
import { useRouter } from 'expo-router';
import React from 'react';
import {View, LogBox, Text} from 'react-native';
import {WebView} from 'react-native-webview';

LogBox.ignoreLogs(['Remote debugger']);
const runFirst = `window.ReactNativeWebView.postMessage("this is message from web");`;

const KakaoLogin = () => {
  const router = useRouter();

  const parseAuthCode = async (url:any) => {
    const exp = 'code='; //url에 붙어 날라오는 인가코드는 code=뒤부터 parse하여 get
    const startIndex = url.indexOf(exp); //url에서 "code="으로 시작하는 index를 찾지 못하면 -1반환
    if (startIndex !== -1) {
      const authCode = url.substring(startIndex + exp.length);
      console.log('access code :: ' + authCode);

      await axios
        .post('본인 url', {
          params: {
            code: authCode,
          },
        })
        .then(res =>{
            AsyncStorage.setItem(
              'userNumber',
              JSON.stringify(res['data']['userId']),
            );
            router.push('/(tabs)');
          }
        );

      // navigate('Home', {screen: 'Home'});
    }
  };

  return (
    <View style={{flex: 1}}>
      <Text>로그인 화면</Text>
      <WebView
        originWhitelist={['*']}
        scalesPageToFit={false}
        style={{marginTop: 30}}
        source={{
          uri: 'https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=본인 rest api key&redirect_uri=본인 url',
        }}
        injectedJavaScript={runFirst}
        javaScriptEnabled={true}
        onMessage={event => {
          parseAuthCode(event.nativeEvent['url']);
        }}

        // onMessage ... :: webview에서 온 데이터를 event handler로 잡아서 logInProgress로 전달
      />
    </View>
  );
};

export default KakaoLogin;