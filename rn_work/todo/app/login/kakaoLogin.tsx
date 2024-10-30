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

    // setBodyContent(data); // 상태 업데이트
    // router.push('/(tabs)');
      await axios
        .get('http://back.hellomh.site/oauth/login', {
          params: {
            code: authCode,
          },
        })
        .then(res =>{
            AsyncStorage.setItem(
              'token',
              res.data,
            );
            console.log("jwt = "+JSON.stringify(res));
          }
        );
        router.push('/(tabs)');

      // navigate('Home', {screen: 'Home'});
    }
  };

  return (
    <View style={{flex: 1}}>
      <WebView
        originWhitelist={['*']}
        setSupportZoom={true}
        useWideViewPort={true}
        // style={{marginTop: 30}}
        source={{
          uri: 'https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=477ea0788a39a67ac40fa6b1bc49e7d8&redirect_uri=http://back.hellomh.site/test/aa',
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