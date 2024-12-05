const Sequelize = require('sequelize');

class User extends Sequelize.Model {
    static initiate(sequelize) {
        User.init({
            name: Sequelize.STRING,
            age: Sequelize.INTEGER,
            married: Sequelize.STRING,
            comment: Sequelize.STRING,
            created_at: {
                type: Sequelize.DATE,
                allowNull: false,
                defaultValue: Sequelize.NOW
            },
        },{
            sequelize,
            timestamps: false,
            underscored: false,
            modelName: 'User',
            tableName: 'users',
            paranoid: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',
        })
    }
    static associate(models) {
        models.User.hasMany(models.Comment,{foreignKey:'commenter',sourceKey:'id'})
    }
}

module.exports = User;