```text
git clone https://github.com/TIME-GATE/spring-boot-api.git
cd spring-boot-api
gradle bootRun

/**
 * Hbase预插入值测试
 * put 'test', 'row1', 'f1:col1', 'hbase'
 * put 'test', 'row2', 'f1:col1', 'hbase'
 */

// 获取全部数据
curl -X GET 'http://127.0.0.1:8080/v1/api/getPersonas?table=test&row=row1'
{
    "code": 0,
    "msg": "请求成功",
    "data": {
        "f1": {
            "123": {
                "1509798188598": "123123"
            },
            "col2": {
                "1509787182607": "value02"
            },
            "col3": {
                "1509787195036": "value03"
            },
            "col1": {
                "1510546688843": "hbase"
            }
        },
        "f2": {
            "123": {
                "1509798471463": "123123"
            },
            "124": {
                "1509798503597": "123123"
            },
            "张": {
                "1509798631188": "123123"
            },
            "name": {
                "1509798612866": "zhang"
            }
        }
    }
}

// 获取某一属性历史数据
curl -X GET 'http://127.0.0.1:8080/v1/api/getColumnVersion?table=test&row=row1&family=f1&column=col1'

{
    "code": 0,
    "msg": "请求成功",
    "data": {
        "f1": {
            "col1": {
                "1510546688843": "hbase",
                "1509787171512": "value02"
            }
        }
    }
}

// 前缀匹配
curl -X GET 'http://127.0.0.1:8080/v1/api/regixRowByPre?table=test&row=row1&family=f1&column=col1'

{
    "code": 0,
    "msg": "请求成功",
    "data": {
        "row1": {
            "f1": {
                "123": {
                    "1509798188598": "123123"
                },
                "col2": {
                    "1509787182607": "value02"
                },
                "col3": {
                    "1509787195036": "value03"
                },
                "col1": {
                    "1510546688843": "hbase"
                }
            },
            "f2": {
                "123": {
                    "1509798471463": "123123"
                },
                "124": {
                    "1509798503597": "123123"
                },
                "张": {
                    "1509798631188": "123123"
                },
                "name": {
                    "1509798612866": "zhang"
                }
            }
        }
    }
}

// 任意匹配
curl -X GET 'http://127.0.0.1:8080/v1/api/regixTableFilter?table=test&match=row2'
{
    "code": 0,
    "msg": "请求成功",
    "data": {
        "row2": {
            "f1": {
                "col1": {
                    "1510548940362": "hbase"
                }
            }
        }
    }
}

```