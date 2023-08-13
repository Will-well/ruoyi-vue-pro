import request from '@/utils/request'

// 创建资讯
export function createInformation(data) {
  return request({
    url: '/system/information/create',
    method: 'post',
    data: data
  })
}

// 更新资讯
export function updateInformation(data) {
  return request({
    url: '/system/information/update',
    method: 'put',
    data: data
  })
}

// 删除资讯
export function deleteInformation(id) {
  return request({
    url: '/system/information/delete?id=' + id,
    method: 'delete'
  })
}

// 获得资讯
export function getInformation(id) {
  return request({
    url: '/system/information/get?id=' + id,
    method: 'get'
  })
}

// 获得资讯分页
export function getInformationPage(query) {
  return request({
    url: '/system/information/page',
    method: 'get',
    params: query
  })
}

// 导出资讯 Excel
export function exportInformationExcel(query) {
  return request({
    url: '/system/information/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
