import { Image, StyleSheet, Platform, View,Text, TouchableOpacity, Alert } from 'react-native';

import { HelloWave } from '@/components/HelloWave';
import ParallaxScrollView from '@/components/ParallaxScrollView';
import { ThemedText } from '@/components/ThemedText';
import { ThemedView } from '@/components/ThemedView';
import axios from 'axios';
import { useState } from 'react';
import { Link } from 'expo-router';
import AsyncStorage from "@react-native-async-storage/async-storage";

export default function HomeScreen() {
  const url = 'http://back.hellomh.site';

  const [thumbnail,setThumbnail] = useState('https://k.kakaocdn.net/14/dn/btsKa5998C8/Vg52HlHN7h9eCsFIoV7jy1/o.jpg');

  const onPress = async() => {
    const token = await AsyncStorage.getItem('token');
    console.log(token);
    try {
      Alert.alert('통신시작'+token);
      const res = await axios.get(`${url}/user/info`, {
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer `+token,
        },
      });
      Alert.alert('통신끝');
      console.log(res);
      Alert.alert(res.status+' '+res.data.thumbnail_image);
      setThumbnail(res.data.thumbnail_image);
      return res;
    } catch (err) {
      console.error(err);
      return err;
    }
  };
  return (
    <View>
      <Link href="/home">home</Link>
      <TouchableOpacity onPress={onPress}>
        <HelloWave />
        <Image
          source={{ uri: thumbnail }}
          style={{ width: 150, height: 150, borderRadius: 75 }}
        />
        <Text style={styles.titleContainer}>
          <ThemedText type="title">My Todo App</ThemedText>
        </Text>
        <ThemedText>
          A simple todo app using React Native and Expo.
        </ThemedText>
        <ThemedText>
          <Text style={{ fontWeight: 'bold' }}>Steps:</Text>
          <ThemedText>1. Create a new React Native project</ThemedText>
          <ThemedText>2. Set up Expo</ThemedText>
          <ThemedText>3. Add necessary dependencies</ThemedText>
          <ThemedText>4. Create the basic screens</ThemedText>
          <ThemedText>5. Add navigation</ThemedText>
          <ThemedText>6. Implement the todo functionality</ThemedText>
        </ThemedText>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  titleContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
  },
  stepContainer: {
    gap: 8,
    marginBottom: 8,
  },
  reactLogo: {
    height: 178,
    width: 290,
    bottom: 0,
    left: 0,
    position: 'absolute',
  },
});
