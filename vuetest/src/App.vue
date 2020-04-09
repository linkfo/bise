<template>
    <div style="height: 100%" id="app">
        <router-view v-if="isRouterAlive"></router-view>

    </div>
</template>

<script>
    export default {
        provide () {
            return {
                reload: this.reload
            }
        },
        data() {
            const item = {
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            };
            return {
                tableData: Array(20).fill(item),
                isRouterAlive: true
            }
        },
        methods: {
            reload () {
                this.isRouterAlive = false
                this.$nextTick(() => (this.isRouterAlive = true))
            }
        },
        created() {
            axios.get("")
        }
    };
</script>

<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>
