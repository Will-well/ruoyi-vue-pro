import request from '@/utils/request'

// 创建用户咨询
export function createConsultation(data) {
  return request({
    url: '/system/consultation/create',
    method: 'post',
    data: data
  })
}

// 更新用户咨询
export function updateConsultation(data) {
  return request({
    url: '/system/consultation/update',
    method: 'put',
    data: data
  })
}

// 删除用户咨询
export function deleteConsultation(id) {
  return request({
    url: '/system/consultation/delete?id=' + id,
    method: 'delete'
  })
}

// 获得用户咨询
export function getConsultation(id) {
  return request({
    url: '/system/consultation/get?id=' + id,
    method: 'get'
  })
}

// 获得用户咨询分页
export function getConsultationPage(query) {
  return request({
    url: '/system/consultation/page',
    method: 'get',
    params: query
  })
}

// 导出用户咨询 Excel
export function exportConsultationExcel(query) {
  return request({
    url: '/system/consultation/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
