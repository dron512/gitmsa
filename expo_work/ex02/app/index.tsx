// export default function Home(){
// }

import { useRouter } from "expo-router";
import { Text, TouchableOpacity, View } from "react-native";


const Index = () => {
    const router = useRouter();
    const onPress = () => {
        router.push('/(tabs)');
    }
    return ( <View style={{marginTop:50}}>
        <Text>
            Index
            RouterLink - router.push
            Link - router.push
        </Text>
        <TouchableOpacity onPress={onPress}>
            <Text>Click Me</Text>
        </TouchableOpacity>
    </View> );
}
 
export default Index;