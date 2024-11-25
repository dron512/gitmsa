const {Sequelize} = require('sequelize');
const app = require("../app");

const sequelize = new Sequelize(
    process.env.DB_NAME || 'msa',  // 데이터베이스 이름
    process.env.DB_USER || 'root',  // 사용자명
    process.env.DB_PASS || '1234',  // 비밀번호
    {
        host: process.env.DB_HOST || 'localhost',  // 호스트
        dialect: 'mariadb',  // 데이터베이스 종류
        logging: false,  // 로깅 비활성화
        port: process.env.DB_PORT || 3306,
    }
);

(async () => {
    // Code logic
    console.log('Database Connected');
    try {
        // MariaDB에 테이블 동기화
        await sequelize.sync({ force: true });
        console.log('Table created successfully!');
    } catch (error) {
        console.error('Error creating table:', error);
    } finally {
        // await sequelize.close();
    }
})();

module.exports = sequelize;