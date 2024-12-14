// redux/counterSlice.js

import { createSlice } from '@reduxjs/toolkit';

// Initial state
const initialState = {
  count: 0,
  token: "",
};

// Create a slice
const counterSlice = createSlice({
  name: 'counter',
  initialState,
  reducers: {
    increment: (state, data) => {
      state.token = data.payload.token;
      state.count += 1;
    },
    decrement: (state) => {
      state.count -= 1;
    },
    reset: (state) => {
      state.count = 0;
    },
  },
});

// Export actions
export const { increment, decrement, reset } = counterSlice.actions;

// Export the reducer to add to the store
export default counterSlice.reducer;
