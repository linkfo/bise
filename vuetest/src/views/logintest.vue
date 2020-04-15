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
        name: "login",
        data() {
            return {
                user: {
                    emid: '',
                    password: '',
                },
                rules: {
                    emid: [
                        {required: true, message: 'id不为空', tigger: "blur"},
                        {min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ]

                },

            }

        },
        methods: {
            onSubmit(formName) {

                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.user)
                        const _this = this;
                        console.log(JSON.stringify(this.user))
                        axios.post('http://localhost:8181/Employee/logintest', this.user).then(function (resp) {
                            console.log(resp);
                            if (resp.data.message == "登录成功") {
                                _this.$message({
                                    message: _this.user.emid + "用户登录成功",
                                    type: 'success'
                                });
                                _this.$emit('func', _this.user.emid)
                                _this.$router.push("/user")
                            }
                            if (resp.data.message == "登录失败,用户不存在") {
                                _this.$message({
                                    showClose: true,
                                    message: "登录失败,用户不存在",
                                    type: 'warning'
                                });
                                //return false;
                            }
                            if (resp.data.message == "登录失败,密码错误") {
                                _this.$message({
                                    showClose: true,
                                    message: "登录失败,密码错误",
                                    type: 'warning'
                                });
                                //return false;
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