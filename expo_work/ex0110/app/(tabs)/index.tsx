import {Alert, Button, Image, StyleSheet, Text, View} from 'react-native';
import {launchImageLibrary} from 'react-native-image-picker';
import {useState} from "react";
import {rgbaColor} from "react-native-reanimated/lib/typescript/Colors";
import axios from "axios";

export default function HomeScreen() {
    const [selectedImage, setSelectedImage] = useState<any>(null);

    const pickImage = async () => {
        // 이미지 선택
        const result = await launchImageLibrary({
            mediaType: 'photo', // 사진 선택
            quality: 1,         // 이미지 품질 (0~1)
        });

        if (result.assets && result.assets.length > 0) {
            const image = result.assets[0];
            setSelectedImage(image);
            console.log('Selected Image:', image);
        }
    };

    const uploadImage = async () => {
        if (!selectedImage) {
            Alert.alert('No Image Selected', 'Please select an image first.');
            return;
        }

        const formData: any = new FormData();

        // FormData에 이미지 추가
        formData.append('image', {
            uri: selectedImage.uri,
            type: selectedImage.type,
            name: selectedImage.fileName,
        });

        try {
            // 서버로 이미지 업로드
            const response = await axios.post('http://54.180.144.215:3000/upload', formData, {
                headers: {'Content-Type': 'multipart/form-data'},
            });

            console.log('Upload Success:', response.data);
            Alert.alert('Upload Success', `Image URL: ${response.data.imageUrl}`);
        } catch (error) {
            console.error('Upload Error:', error);
            Alert.alert('Upload Failed', 'Something went wrong while uploading the image.');
        }
    };

    return (
        <View style={styles.container}>
            <View>
                <Text style={{color: '#efefef', fontSize: 25,margin:50}}>
                    Hello
                </Text>
                {selectedImage && (
                    <View style={{flexDirection:"row",gap:10}}>
                        <Image source={{uri: selectedImage.uri}} style={styles.image}/>
                        <Image source={{uri: selectedImage.uri}} style={styles.image}/>
                    </View>
                )}
            </View>
            <View>
                <Button title="Pick Image" onPress={pickImage}></Button>
                <Button title="Upload Image" onPress={uploadImage}/>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
    image: {
        width: 200,
        height: 200,
        marginBottom: 20,
        borderRadius: 10,
    },
});
