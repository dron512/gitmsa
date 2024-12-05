const mongoose = require('mongoose');

const {Schema} = mongoose;

const roomSchema = new Schema({
    room: {
        type: Schema.Types.ObjectId,
        required: true,
        ref: 'Room'
    },
    user: {
        type: String,
        required: true,
    },
    chat: String,
    gif: String,
    create_at:{
        type: Date,
        default: Date.now
    }
})

module.exports = mongoose.model('Chat', roomSchema);