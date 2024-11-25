const express = require('express');
const router = express.Router();

const {addCatalog, findCatalogs} = require('../models');

router.post('', async (req, res) => {
    try {
        const catalog = await addCatalog({
            productId: req.body.productId,
            productName: req.body.productName,
            stock: req.body.stock,
            unitPrice: req.body.unitPrice,
        });
        console.log('Catalog created', catalog);
        res.json({catalog})
    } catch (err) {
        res.json({message: 'Error creating catalog'});
    }

})

router.get('', async (req, res) => {
    const catalogs = await findCatalogs();
    console.log('Catalog created', catalogs);
    res.json({catalogs})
})

module.exports = router;