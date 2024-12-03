const Sequelize = require('sequelize');
const {Model} = require("sequelize");

class User extends Sequelize.Model {
    static initiate(sequelize) {
        User.init({
            email: {
                type: Sequelize.STRING,
                unique: true,
                allowNull: true,
            },
            nink: {
                type: Sequelize.STRING,
                allowNull: false,
            },
            password: {
                type: Sequelize.STRING,
                allowNull: true,
            },
            provider: {
                type: Sequelize.ENUM('local', 'kakao'),
                allowNull: false,
                defaultValue: 'local',
            },
            snsId: {
                type: Sequelize.STRING,
                allowNull: true,
            }
        }, {
            sequelize,
            timestamps: true,
            underscored: true,
            modelName: 'User',
            tableName: 'users',
            paranoid: true,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',
        })
    }

    // 팔로워는 나를 구독하는 사람
    // 팔로잉은 내가 구독하고 있는사람
    static associate(models) {
        models.User.hasMany(models.Post);
        models.User.belongsToMany(models.User, {
            foreignKey: 'follwingId',
            as: "Followers",
            through: 'Follow',
        });
        models.User.belongsToMany(models.User, {
            foreignKey: 'followerId',
            as: "Followings",
            through: 'Follow',
        })
    }
}

module.exports = User;