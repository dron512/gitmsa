import { View, Text, SafeAreaView, StatusBar, ScrollView, TouchableOpacity } from 'react-native'
import React, { useEffect } from 'react'
import FontAwesome from 'react-native-vector-icons/FontAwesome';
import Feather from 'react-native-vector-icons/Feather';
import Stories from '../components/Stories';
import Post from '../components/Post';
import PushNotification from 'react-native-push-notification';

const Home = () => {

  useEffect(() => {
    createChannel();
  }, [])

  const createChannel = () => {
    PushNotification.createChannel({
      channelId: "insta-channel",
      channelName: "Insta Channel"
    },
      (created) => console.log(`createChannel returned '${created}'`) 
      // (optional) callback returns whether the channel was created, false means it already existed.
    )
  }

  return (
    <SafeAreaView style={{ backgroundColor: 'white' }}>
      <StatusBar
        backgroundColor="white"
        barStyle="dark-content"
      />
      <View
        style={{
          justifyContent: 'space-between',
          flexDirection: 'row',
          paddingHorizontal: 15,
          alignItems: 'center',
        }}>
        <View>
          <Text
            style={{
              fontSize: 25,
              fontWeight: '500',
            }}>
            Instagram
          </Text>
        </View>
        <View
          style={{
            justifyContent: 'space-between',
            flexDirection: 'row',
            alignItems: 'center',
          }}
        >
          <FontAwesome name="plus-square-o" style={{ fontSize: 24, paddingHorizontal: 15 }} />
          <Feather name="navigation" style={{ fontSize: 24 }} />
        </View>
      </View>
      <ScrollView>
        {/* Stories */}
        <Stories />
        {/* Posts */}
        <Post />
      </ScrollView>
    </SafeAreaView>
  )
}

export default Home