const sequelize = require('../db');
const {Catalog} = require('./Catalogs');

(async () => {
    try {
        // 테이블 재생성
        await sequelize.sync({force: true});
    } catch (err) {
        console.log(err)
    }
})()
;
const addCatalog = async ({productId,productName,stock,unitPrice})=>{
    try{
        const newCatalog1 = await Catalog.create({
            productId,
            productName,
            stock,
            unitPrice,
        });
        return newCatalog1;
    }catch (err){
        console.log(err);
        throw err;
    }
}

const findCatalogs = async ()=>{
    try{
        const catalogs = await Catalog.findAll();
        return catalogs;
    }catch (err){
        console.log(err);
        throw err;
    }
}

(async () => {

    try{
        // 테이블 재생성
        await sequelize.sync({force: true});

        const newCatalog1 = await Catalog.create({
            productId: 'p-001',
            productName: '향수',
            stock: 100,
        });

        console.log('Catalog created',newCatalog1.toJSON());
        const newCatalog2 = await Catalog.create({
            productId: 'p-002',
            productName: '엄청난제품',
            stock: 100,
        })
        console.log('Catalog created',newCatalog2.toJSON());
        const newCatalog3 = await Catalog.create({
            productId: 'p-003',
            productName: '정말좋은제품',
            stock: 100,
        })
        console.log('Catalog created',newCatalog3.toJSON());

        const catalogs = await Catalog.findAll();
        console.log('All Catalogs created',catalogs.map(catalog => catalog.toJSON()));

        // UPDATE : 모든 카탈로그 항목 업데이트
        const updateCatalog = await Catalog.update(
            { stock: 120},
            {where: {productId: 'T01'}}
        );
        console.log('Update Catalog',updateCatalog);

        await Catalog.destroy({where: {productId: 'T-01'}});
        console.log('Destroy Catalog');
    }catch (error){
        console.log(error);
    }finally {
        // await sequelize.close();
    }

})();

module.exports = {addCatalog,findCatalogs};