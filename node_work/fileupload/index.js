const express = require('express');
const multer = require('multer');
const path = require('path');
const swaggerUi = require('swagger-ui-express');
const swaggerSpec = require('./config/swaggerconfig'); // Swagger 설정 불러오기

const app = express();

app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpec));

// 서버 시작
app.listen(3000, () => {
    console.log('Server running on port 3000');
    console.log('Swagger Docs available at http://localhost:3000/api-docs');
});
