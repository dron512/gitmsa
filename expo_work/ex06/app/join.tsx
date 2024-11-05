import axios from "axios";
import { StatusBar } from "expo-status-bar";
import {
  Text,
  View,
  TouchableOpacity,
  TextInput,
  Pressable,
  Alert,
} from "react-native";

export default function App() {
  const doSignUp = async () => {
    try {
      const res = await axios.post("http://m.hellomh.site/users/join", {
        email: "ddd@naver.com",
        name: "홍길동",
        password: "abcd1234",
      });

      if (res.status == 200) {
        Alert.alert("Sign Up", "회원가입이 완료되었습니다.");
        return;
      }
      // console.log(JSON.stringify(res));
    } catch (err) {
      // console.error(JSON.stringify(err));
      Alert.alert("Sign Up", "회원가입에 실패하였습니다." + err.response.data);
      return;
    }
  };

  return (
    <View
      style={{
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#FFF",
      }}
    >
      <StatusBar style="auto" />
      <Text
        style={{
          textAlign: "center",
          marginTop: 1,
          fontSize: 36,
          color: "#FF3300",
        }}
      >
        WelcomeToMyAPP
      </Text>
      {/* Additional components goes here */}
      <View style={{ marginTop: 10, marginHorizontal: 10 }}>
        <View>
          <Text style={{ color: "#2c2c2c" }}>EMAIL:</Text>
          <TextInput
            placeholder="Enter Email..."
            style={{
              borderWidth: 1,
              borderColor: "White",
              marginTop: 10,
              borderStyle: "dotted",
              padding: 10,
              color: "#2c2c2c",
            }}
          />
        </View>
        <View style={{ marginTop: 10 }}>
          <Text className="text-gray-400">PASSWORD:</Text>
          <TextInput
            secureTextEntry
            placeholder="Enter Password..."
            className="border text-gray-500 border-dotted p-2 border-amber-400 mt-1"
          />
        </View>

        <View className="bg-slate-500 p-3 my-5">
          <TouchableOpacity onPress={doSignUp}>
            <Text className="text-center font-normal text-white text-base">
              SingUp
            </Text>
          </TouchableOpacity>
        </View>

        <Text className="text-center font-normal text-gray-500 text-base mt-3">
          OR
        </Text>
        <View className="bg-slate-500 p-3 my-5">
          <TouchableOpacity>
            <Text className="text-center font-normal text-white text-base">
              Sign in with Google
            </Text>
          </TouchableOpacity>
        </View>
        <View className="mt-6 flex-row justify-center">
          <Text className="">New to FreeCodeCamp? </Text>
          <TouchableOpacity>
            <Text className="text-amber-500">Create an Account</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
}
