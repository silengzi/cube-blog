import request from './request'
export const reqAllArticle = (data) => request({
    url: '/article/getAllArticle',
    method: 'get',
    params: data,
})
export const reqArticleById = (data) => request({
    url: '/article/getArticleById',
    method: 'get',
    params: data,
})
export const reqCreateArticle = (data) => request({
    url: '/article/createArticle',
    method: 'post',
    data
})
export const reqUpdateArticle = (data) => request({
    url: '/article/updateArticle',
    method: 'post',
    data
})
export const reqDeleteArticle = (data) => request({
    url: '/article/deleteArticle',
    method: 'post',
    data
})
export const reqAllUser = () => request({
    url: '/user/getAllUser'
})

