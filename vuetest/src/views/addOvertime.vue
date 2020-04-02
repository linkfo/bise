<template>
<div>
    <el-form ref="user" :model="user" :rules="rules" label-width="80px" size="mini">
        <el-form-item label="id" prop="emid">
        <el-input v-model="user.emid"></el-input>
    </el-form-item>
        <el-form-item label="password" prop="password">
            <el-input v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item label="name" prop="name">
            <el-input v-model="user.name"></el-input>
        </el-form-item>
        <el-form-item label="age" prop="age">
            <el-input v-model="user.age"></el-input>
        </el-form-item>

        <el-form-item label="性别" prop="gender">
            <el-select v-model="user.gender" placeholder="请选择性别">
                <el-option label="男" value="M"></el-option>
                <el-option label="女" value="W"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="Identity" prop="identity">
            <el-input v-model="user.identity"></el-input>
        </el-form-item>
        <el-form-item label="bankid" prop="bankid">
            <el-input v-model="user.bankid"></el-input>
        </el-form-item>
        <el-form-item label="tel" prop="tel">
            <el-input v-model="user.tel"></el-input>
        </el-form-item>
        <el-form-item label="department" prop="department">
            <el-input v-model="user.department"></el-input>
        </el-form-item>
        <el-form-item label="position" prop="position">
            <el-input v-model="user.position"></el-input>
        </el-form-item>
        <el-form-item label="note" prop="note">
            <el-input v-model="user.note"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit('user')">立即创建</el-button>
            <el-button @click="resetForm('user')">重置</el-button>

        </el-form-item>
    </el-form>
</div>
</template>

<script>
    export default {
        name:"addOvertime",
        data() {
            return {
                user: {
                    emid: '',
                    password:'',
                    name: '',
                    age:'',
                    gender: '',
                    identity: '',
                    bankid: '',
                    tel: '',
                    department: '',
                    position: '',
                    note: '',
                    desc: ''
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
                        axios.post('http://localhost:8181/Employee/insertTest',this.user).then(function (resp) {
                            console.log(_this.user.emid)
                            console.log(resp)
                            if(resp.data.emid==_this.user.emid){
                                _this.$message({
                                    message: _this.user.emid+'添加成功',
                                    type: 'success'
                                });
                                _this.$router.push("/user")
                            }
                        })
                    } else {
                        _this.$message({
                            showClose: true,
                            message: '添加失败',
                            type: 'warning'
                        });
                        return false;
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