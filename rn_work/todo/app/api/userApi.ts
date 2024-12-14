import AsyncStorage from "@react-native-async-storage/async-storage";
import axios from "axios";

export const join= async(data:any)=>{
  console.log("test");
  try{
    const res = await axios.post('http://m.hellomh.site/users/join', data)
    console.log(res);
    return res;
  }catch(err){
    console.log(err);
  };
  
}


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
