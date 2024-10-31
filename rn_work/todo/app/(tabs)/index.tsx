import React, { useState, useRef } from "react";
import {
  View,
  Text,
  StyleSheet,
  Image,
  TouchableOpacity,
  ScrollView,
  Modal,
  Animated,
} from "react-native";
import { TabBarIcon } from "@/components/navigation/TabBarIcon";

export default function Index() {
  const [modalVisible, setModalVisible] = useState(false);
  const slideAnim = useRef(new Animated.Value(-300)).current; // Initial position off-screen

  const doModal = () => {
    setModalVisible(!modalVisible);
    Animated.timing(slideAnim, {
      toValue: modalVisible ? -300 : 0, // Slide in when modal is shown
      duration: 300,
      useNativeDriver: true,
    }).start();
  };

  return (
    <ScrollView style={styles.container}>
      {/* Top Bar */}
      <View style={styles.topBar}>
        <TouchableOpacity onPress={doModal}>
          <TabBarIcon name={"menu"} />
        </TouchableOpacity>
        <TouchableOpacity>
          <Image
            source={require("../../assets/images/lotto.png")} // 파일 경로에 맞게 수정
            style={styles.icon}
          />
        </TouchableOpacity>
      </View>

      {/* Left-Side Modal */}
      <Modal
        transparent={true}
        visible={modalVisible}
        animationType="none"
        onRequestClose={doModal}
      >
        <TouchableOpacity style={styles.overlay} onPress={doModal} />
        <Animated.View
          style={[styles.sideMenu, { transform: [{ translateX: slideAnim }] }]}
        >
          <TouchableOpacity
            style={styles.closeButton}
            onPress={doModal}
            hitSlop={{ top: 10, bottom: 10, left: 10, right: 10 }}
          >
            <Text style={styles.closeButtonText}>메뉴닫기</Text>
          </TouchableOpacity>

          {/* Menu Items */}
          <Text style={styles.modalText}>Menu Item 1</Text>
          <Text style={styles.modalText}>Menu Item 2</Text>
          <Text style={styles.modalText}>Menu Item 3</Text>
          {/* Add more menu items as needed */}
        </Animated.View>
      </Modal>

      {/* Lottery Numbers */}
      <View style={styles.lotteryContainer}>
        <Text style={styles.drawInfo}>1139회 당첨번호</Text>
        <View style={styles.numbersContainer}>
          {["5", "12", "15", "30", "37", "40", "+18"].map((num, index) => (
            <View key={index} style={styles.numberCircle}>
              <Text style={styles.numberText}>{num}</Text>
            </View>
          ))}
        </View>
        <Text style={styles.prizeInfo}>1등 13게임 총 당첨금액 약 282억 원</Text>
      </View>

      {/* Rest of your code... */}
    </ScrollView>
  );
}
// 모든 Text 컴포넌트의 기본 스타일 설정

Text.defaultProps = {
  ...(Text.defaultProps || {}),
  style: { fontFamily: 'NotoSansBlack' }
};

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: "#f2f2f2", marginTop: 30 },
  topBar: {
    flexDirection: "row",
    justifyContent: "space-between",
    padding: 16,
    backgroundColor: "#fff",
  },
  closeButtonWrapper: {
    position: "absolute",
    top: 5,
    right: 5,
    padding: 15, // Increase the touchable area around the button
  },
  iconContainer: { flexDirection: "row" },
  icon: { width: 90, height: 30, marginLeft: 16 },
  lotteryContainer: { padding: 16, backgroundColor: "#fff", marginVertical: 8 },
  drawInfo: {
    fontSize: 16,
    fontWeight: "bold",
    marginBottom: 8,
    fontFamily: "NotoSansBlack",
  },
  numbersContainer: {
    flexDirection: "row",
    justifyContent: "center",
    marginBottom: 8,
  },
  numberCircle: {
    width: 36,
    height: 36,
    borderRadius: 18,
    backgroundColor: "#eee",
    alignItems: "center",
    justifyContent: "center",
    marginHorizontal: 4,
  },
  numberText: { fontSize: 16, fontWeight: "bold" },
  prizeInfo: { textAlign: "center", color: "#888", fontSize: 14, fontFamily:"NotoSansBold" },
  overlay: {
    flex: 1,
    backgroundColor: "rgba(0,0,0,0.5)",
    position: "absolute",
    width: "100%",
    height: "100%",
  },
  sideMenu: {
    width: 300,
    height: "100%",
    backgroundColor: "#fff",
    padding: 16,
    position: "absolute",
    left: 0,
  },
  modalText: { fontSize: 18, paddingVertical: 10 },
  bottomNav: {
    flexDirection: "row",
    justifyContent: "space-around",
    backgroundColor: "#fff",
    paddingVertical: 16,
  },
  bottomNavText: { fontSize: 14, color: "#333" },
  closeButton: {
    padding: 10, // Increase padding to make it easier to press
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "#ddd",
  },
  closeButtonText: {
    fontSize: 16,
    color: "#333",
    fontWeight: "bold",
  },
});
