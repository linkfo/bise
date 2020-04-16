<template>
    <div>
        <el-form ref="user" :model="user" :rules="rules" label-width="80px" size="mini">
            <el-form-item label="id" prop="olid">
                <el-input v-model="user.olid"></el-input>
            </el-form-item>
            <el-form-item label="员工id" prop="emid">
                <el-input v-model="user.emid"></el-input>
            </el-form-item>
            <el-form-item label="name" prop="name">
                <el-input v-model="user.name"></el-input>
            </el-form-item>

            <el-form-item label="day(年-月-日)" prop="day">
                <el-input v-model="user.day"></el-input>
            </el-form-item>

            <el-form-item label="hour" prop="hour">
                <el-input v-model="user.hour"></el-input>
            </el-form-item>
            <el-form-item label="备注" prop="note">
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
        name:"addAttendance",
        data() {
            return {
                user: {
                    olid: '',
                    emid:'',
                    name: '',
                    day:'',
                    hour: '',
                    note: '',
                },
                rules: {
                    olid: [
                        {required: true, message:'id不为空',tigger:"blur"},
                        { min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],
                    emid: [
                        {required: true, message:'员工id不为空',tigger:"blur"},
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
                        axios.post('http://localhost:8181/Overtime/update',this.user).then(function (resp) {
                            console.log(_this.user.olid)
                            console.log(resp)
                            if(resp.data.olid==_this.user.olid){
                                _this.$message({
                                    message: _this.user.olid+'修改成功',
                                    type: 'success'
                                });
                                _this.$router.push("/overtime")
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
        },
        created() {
            alert( this.$route.query.olid);
            const _this=this;
            axios.get('http://localhost:8181/Overtime/update/'+this.$route.query.olid).then(function (resp) {
                console.log(resp.data);
                _this.user=resp.data
            })

        }

    }
</script>

<style scoped>

</style>