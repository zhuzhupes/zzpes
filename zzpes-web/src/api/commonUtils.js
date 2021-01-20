import request from '@/utils/request'

/**
 * 获取所有链接
 * @param url 链接名字
 * @returns {*} 返回的数据
 */
export function fetchList(url) {
  url = url+'/allList';
  return request({
    url: url,
    method:'get'
  });
}


/**
 * 检查option是否在list中，根据key判断
 * @param option 选项
 * @param list 对应列表
 * @param key key值
 * @returns {*} 所有属性
 */
export function checkIsIn(option, list, key){
  if(key == null || key === ''){
    return list.findIndex((item, i)=>{
      return item === option
    });
  }else{
    return list.findIndex((item, i)=>{
      return item[key] === option[key]
    });
  }
}

/**
 * 为list增加 ‘label’标签
 * @param list 需要增加的list
 * @param keys 显示标签的值依据
 * @returns {*} 调整后的list
 */
export function addLabelToItem(list, keys){
  for(var item of list){
    var label = "";
    for(var key of keys){
      if(label === ""){
        label = item[key];
      }else{
        label = label + '/' + item[key];
      }
    }
    item['label'] = label;
  }
  return list;
}
