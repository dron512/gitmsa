const Sequelize = require('sequelize');

class Comment extends Sequelize.Model {
    static initiate(sequelize) {
        Comment.init({
                comment: {
                    type: Sequelize.STRING,
                },
                create_at: Sequelize.DATE,
            },
            {
                sequelize,
                timestamps: false,
                modelName: 'Comment',
                tableName: 'comments',
                paranoid: false,
                charset: 'utf8mb4',
                collate: 'utf8mb4_general_ci',
            })
    }

    static associate(models) {
        models.Comment.belongsTo(models.User, {foreignKey: "commenter", targetKey: "id"})
    }
}

module.exports = Comment;