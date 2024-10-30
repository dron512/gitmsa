import AsyncStorage from "@react-native-async-storage/async-storage";
import axios from "axios";

export const login= async()=>{
    const authCode = await AsyncStorage.getItem('authCode');
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
}
