const Sequelize = require('sequelize');

class Post extends Sequelize.Model {
    static initiate(sequelize) {
        Post.init({
            content: {
                type: Sequelize.STRING,
                allowNull: false,
            },
            img:{
                type: Sequelize.STRING,
                allowNull: true
            }
        },{
            sequelize,
            timestamps: true,
            underscored: true,
            modelName: 'Post',
            tableName: 'posts',
            paranoid: false,
            charset:"utf8mb4",
            collate: "utf8mb4_general_ci",
        })
    }
    static associate(models) {
        models.Post.belongsTo(models.User);
        models.Post.belongsToMany(models.Hashtag, {through: 'PostHashtag'})
    }
}

module.exports = Post;