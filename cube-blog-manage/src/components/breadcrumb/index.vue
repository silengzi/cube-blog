<template>
    <el-breadcrumb class="breadcrumb" separator="/">
        <transition-group name="breadcrumb">
            <el-breadcrumb-item
                v-for="(item, index) in levelList"
                :key="item.path"
            >
                <span>{{item.meta.title}}</span>
            </el-breadcrumb-item>
        </transition-group>
    </el-breadcrumb>
</template>

<script>
export default {
    name:'',
    data() {
        return {
            levelList: null
        };
    },
    created() {
        this.getBreadcrumb()
    },
    methods: {
        getBreadcrumb() {
            let matched = this.$route.matched.filter(item => item.meta && item.meta.title)
            const first = matched[0]
            if (!this.isDashboard(first)) {
                matched = [{path: '/dashboard', meta: {title: 'Dashboard'}}].concat(matched)
            }
            this.levelList = matched.filter(item => item.meta && item.meta.title && item.meta.breadcrumb !== false)
        },
        isDashboard(route) {
            const name = route && route.name
            if(!name) {
                return false
            }return name.trim().toLocaleLowerCase() === 'Dashboard'.toLocaleLowerCase()
        }
    }
};
</script>

<style scoped lang="less">
    .breadcrumb {
        display: inline-block;
        font-size: 14px;
        margin-left: 8px;
        line-height: 18px;

        span {
            color: #97a8be;
        }
    }
</style>
