import Ionicons from "@expo/vector-icons/Ionicons";
import {
  StyleSheet,
  Image,
  Platform,
  TouchableOpacity,
  View,
  Linking,
} from "react-native";

import { Collapsible } from "@/components/Collapsible";
import { ExternalLink } from "@/components/ExternalLink";
import ParallaxScrollView from "@/components/ParallaxScrollView";
import { ThemedText } from "@/components/ThemedText";
import { ThemedView } from "@/components/ThemedView";
import { useState } from "react";

export default function TabThirdScreen() {
  const [data, setData] = useState("data");

  const doKakao = () => {
    Linking.openURL("https://kauth.kakao.com/oauth/authorize?client_id=477ea0788a39a67ac40fa6b1bc49e7d8&redirect_uri=http://back.hellomh.site/oauth/kakao/callback&response_type=code")
  };

  return (
    <ParallaxScrollView
      headerBackgroundColor={{ light: "#D0D0D0", dark: "#353636" }}
      headerImage={
        <Ionicons size={310} name="code-slash" style={styles.headerImage} />
      }
    >
      <ThemedView style={styles.titleContainer}>
        <ThemedText type="title">Explore</ThemedText>
        <TouchableOpacity onPress={doKakao}>
          <ThemedText type="defaultSemiBold">Kakao Login</ThemedText>
        </TouchableOpacity>
      </ThemedView>
      <Collapsible title="Animations">
        <ThemedText>
          This template includes an example of an animated component. The{" "}
          <ThemedText type="defaultSemiBold">
            components/HelloWave.tsx
          </ThemedText>{" "}
          component uses the powerful{" "}
          <ThemedText type="defaultSemiBold">
            react-native-reanimated
          </ThemedText>{" "}
          library to create a waving hand animation.
        </ThemedText>
        {Platform.select({
          ios: (
            <ThemedText>
              The{" "}
              <ThemedText type="defaultSemiBold">
                components/ParallaxScrollView.tsx
              </ThemedText>{" "}
              component provides a parallax effect for the header image.
            </ThemedText>
          ),
        })}
      </Collapsible>
      <View>
        <ThemedText>
          <TouchableOpacity
            onPress={() => {
              setData(data + "!");
            }}
          >
            <ThemedText type="defaultSemiBold">data = {data}</ThemedText>
            <ThemedText type="defaultSemiBold">
              Press me // Press me! when I'm clicked.
            </ThemedText>
          </TouchableOpacity>
        </ThemedText>
      </View>
    </ParallaxScrollView>
  );
}

const styles = StyleSheet.create({
  headerImage: {
    color: "#808080",
    bottom: -90,
    left: -35,
    position: "absolute",
  },
  titleContainer: {
    flexDirection: "row",
    gap: 8,
  },
});
