// redux/store.js
import { configureStore } from '@reduxjs/toolkit';
import counterReducer from './counterSlice';

// Configure the store
const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
});

export default store;
