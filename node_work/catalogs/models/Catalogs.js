const {DataTypes} = require('sequelize');
const sequelize = require('../db');

const Catalog = sequelize.define('Catalog', {
        id: {
            type: DataTypes.BIGINT,
            autoIncrement: true,
            primaryKey: true,
        },
        productId: {
            type: DataTypes.STRING(120),
            allowNull: false,
            unique: true,
        },
        productName: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        stock: {
            type: DataTypes.INTEGER,
            allowNull: false,
        },
        unitPrice: {
            type: DataTypes.INTEGER,
            allowNull: false,
        },
        createdAt: {
            type: DataTypes.DATE,
            allowNull: false,
            defaultValue: DataTypes.NOW,
        }
    },
    {
        tableName: 'catalog',
        timestamps: false
    });

module.exports = {Catalog};