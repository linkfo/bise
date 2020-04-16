<template>
    <div id="app">
        <el-container style="height: 100%; border: 1px solid #eee">
            <el-aside width="200px" style="height: 100%;background-color: rgb(238, 241, 246)">
                <el-menu router :default-openeds="['0','1','2','3']">
                    <el-submenu v-for="(item,index) in $router.options.routes" :index="index +''" v-if="item.show">
                        <template slot="title"><i class="el-icon-user"></i>{{item.name}}</template>
                        <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                                      :class="$route.path==item2.path?'is-active':''">{{item2.name}}
                        </el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-container style="height: 100%;">
                <el-header style="text-align: right; font-size: 12px">
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item @click.native="login()">登录</el-dropdown-item>
                            <el-dropdown-item @click.native="exit()">退出</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span @func="getemid">{{emid}}</span>
                </el-header>
                <el-main style="height: 100%;">
                    <router-view></router-view>
                </el-main>
            </el-container>

        </el-container>
    </div>
</template>

<script>
    import login from "./login";
    export default {
        name: "index",
        data() {
            return {
                emid: "",
            }

        },
        methods: {
            login(){
                this.$router.push({
                    path:"/login"
                })
            },
            exit(){
                this.$router.push({
                    path: "/login"

                })
            },
            getemid(data){
                this.emid=data
                alert(this.emid)
            }

        }

    }
</script>

<style scoped>

</style>