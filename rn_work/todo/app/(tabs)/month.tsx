import {
  ScrollView,
  View,
  Text,
  StyleSheet,
  TouchableOpacity,
  FlatList,
} from "react-native";
import dayjs from "dayjs";
import { useEffect, useState } from "react";
import { TabBarIcon } from "@/components/navigation/TabBarIcon";
import { fillEmptyColumns } from "@/constants/utils";

const styles = StyleSheet.create({
  container: {
    marginTop: 30,
    flex: 1,
    padding: 16,
    backgroundColor: "#F5FCFF",
  },
  title: {
    fontSize: 50,
    fontFamily: "JUA",
    marginBottom: 16,
  },
});
const Month = () => {
  const [now, setNow] = useState(dayjs());

  fillEmptyColumns(now);

  useEffect(() => {}, []);

  return (
    <ScrollView style={styles.container}>
      <TouchableOpacity onPress={()=>{setNow(dayjs())}}>
        <Text>오늘</Text>
      </TouchableOpacity>
      <View
        style={{
          flexDirection: "row",
          justifyContent: "center",
        }}
      >
        <TouchableOpacity
          onPress={() => {
            setNow(now.subtract(1, "month"));
          }}
        >
          <TabBarIcon style={{ padding: 16 }} name={"arrow-back"} />
        </TouchableOpacity>
        <Text style={styles.title}>{now.format("YY년MM일")}</Text>
        <TouchableOpacity
          onPress={() => {
            setNow(now.add(1, "month"));
          }}
        >
          <TabBarIcon style={{ padding: 16 }} name={"arrow-forward"} />
        </TouchableOpacity>
      </View>

    </ScrollView>
  );
};

export default Month;
