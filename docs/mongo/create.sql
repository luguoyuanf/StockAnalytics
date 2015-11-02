use sta
db.user.ensureIndex({"name":1,"age":-1})
/*股票数据索引*/
db.stockinfo.ensureIndex({"name":1,"cdate":-1,"code":1})
db.stockinfo.ensureIndex({"cdate":-1})