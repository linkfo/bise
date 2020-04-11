<template>
    <div>
        <el-form ref="user" :model="user" :rules="rules" label-width="80px" size="mini">
            <el-form-item label="id" prop="emid">
                <el-input v-model="user.emid"></el-input>
            </el-form-item>
            <el-form-item label="password" prop="password">
                <el-input v-model="user.password"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit('user')">登录</el-button>
                <el-button @click="resetForm('user')">重置</el-button>

            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name:"login",
        data() {
            return {
                user: {
                    emid: '',
                    password:'',
                },
                rules: {
                    emid: [
                        {required: true, message:'id不为空',tigger:"blur"},
                        { min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ]

                },

            }

        },
        methods: {
            onSubmit(formName) {

                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.user)
                        //alert( this.data.emid);
                        const _this=this;
                        axios.get('http://localhost:8181/Employee/login/'+this.user.emid+"/"+this.user.password).then(function (resp) {
                            console.log(resp.data);
                            if (resp.data==_this.user.emid){
                                _this.$message({
                                    message: _this.user.emid+"用户登录成功",
                                    type: 'success'
                                });
                                _this.$emit('func',_this.user.emid)
                                _this.$router.push("/user")


                            }else {
                                _this.$message({
                                    showClose: true,
                                    message: "用户或密码不正确",
                                    type: 'warning'
                                });
                                return false;
                            }

                        })
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }

    }
</script>

<style scoped>

</style>