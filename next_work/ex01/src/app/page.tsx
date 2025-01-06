'use client';

import {useEffect, useState} from "react";
import axios, {AxiosResponse} from "axios";
import {io} from "socket.io-client";
import type {Socket} from "socket.io-client";

interface Room {
    _id: string;
    title: string,
    max: number,
    password: string,
}

export default function Home() {
    const [rooms, setRooms] = useState<Room[]>([]);
    const [title, setTitle] = useState("");
    const [max, setMax] = useState(10);
    const [password, setPassword] = useState("");

    const loadData: () => Promise<void> = async () => {
        const res = await axios.get("http://localhost:8005");
        console.log(res.data.rooms);
        setRooms(res.data.rooms);
    }

    const createRoom = async () => {
        const res: AxiosResponse = await axios.post('http://localhost:8005/', {
            title,
            max,
            password,
        });
        console.log(res);
    };

    useEffect(() => {
        loadData();
        const socket: Socket = io("http://localhost:8005/room");
        socket.on('newRoom', () => {
            console.log("New room");
        })
    }, []);
    return (
        <div>
            <h1 className="text-5xl">채팅방</h1>
            방제목 <input type="text" name="title" id="title" onChange={(e) => setTitle(e.target.value)}
                       className="border border border-gray-500 p-3 hover:bg-gray-300"/><br/>
            방인원수 <input type="number" name="max" id="max" value={10} onChange={e => setMax(Number(e.target.value))}
                        className="border border border-gray-500 p-3 hover:bg-gray-300"/><br/>
            방비밀번호 <input type="text" name="password" id="password" onChange={e => setPassword(e.target.value)}
                         className="border border border-gray-500 p-3 hover:bg-gray-300"/><br/>
            <button className="border border-gray-500 p-3 hover:bg-gray-300"
                    onClick={createRoom}>방만들기
            </button>
            <div>
                {
                    rooms && rooms.map(
                            (room) => (
                            <div key={room._id}><h1>{room.title}</h1></div>
                        )
                    )
                }
            </div>
        </div>
    );
}
