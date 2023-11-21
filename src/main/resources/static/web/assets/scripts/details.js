setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                current: [],
                episode: {},
                selectEp: [],
                comentaries: [],
                queryId: '',
                isLoading: false,
                //add Comment
                commentText: '',
                commentId: null,
                //others
                backMsg: ''
            }
        },
        created() {
            this.getCurrent()
            this.queryId = new URLSearchParams(location.search).get('id')
            axios.get(`/api/episodes/${this.queryId}`)
                .then(res => {
                    this.episode = res.data
                    this.comentaries = this.episode.comentarySet.sort((a, b) => b.id - a.id)
                }).catch(err => console.log(err))
        },
        methods: {
            logOut() {
                axios.post("/api/logout")
                    .then(res => {
                        if (res.status == 200) {
                            Swal.fire({
                                position: 'center',
                                // icon: 'success',
                                title: 'Bye bye!',
                                showConfirmButton: false,
                                timer: 1500
                            })
                            setTimeout(() => {
                                window.location.href = "/web/index.html";
                            }, 1800)
                        }
                        console.log(res)
                    }).catch(err => {
                        Swal.fire({
                            position: 'center',
                            title: 'Cant log out, try again!',
                            showConfirmButton: false,
                            timer: 1500
                        })
                    })
            },
            getCurrent() {
                axios.get(`/api/getCurrent`)
                    .then(res => {
                        this.current = res.data
                    }).catch(err => console.log(err))
            },
            addComment() {
                this.commentId = this.episode.id
                if (this.commentText && this.commentId) {
                    axios.post(`/api/episodes/addComment`, `comment=${this.commentText}&id=${this.commentId}`)
                        .then(res => {
                            this.backMsg = res.data
                            Swal.fire({
                                position: 'center',
                                // icon: 'success',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
                            setTimeout(() => {
                                location.reload();
                            }, 1600)
                        }).catch(err => {
                            this.backMsg = err.response.data
                            Swal.fire({
                                position: 'center',
                                // icon: 'error',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
                        })
                } else {
                    Swal.fire({
                        position: 'center',
                        // icon: 'error',
                        title: `No has agregado un comentario`,
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            },
            enterCom: function () {
                this.commentId = this.episode.id
                if (this.current.length != 0) {
                    if (this.commentText && this.commentId) {
                        axios.post(`/api/episodes/addComment`, `comment=${this.commentText}&id=${this.commentId}`)
                            .then(res => {
                                this.backMsg = res.data
                                Swal.fire({
                                    position: 'center',
                                    // icon: 'success',
                                    title: `${this.backMsg}`,
                                    showConfirmButton: false,
                                    timer: 1500
                                })
                                setTimeout(() => {
                                    location.reload();
                                }, 1600)
                            }).catch(err => {
                                this.backMsg = err.response.data
                                Swal.fire({
                                    position: 'center',
                                    // icon: 'error',
                                    title: `${this.backMsg}`,
                                    showConfirmButton: false,
                                    timer: 1500
                                })
                            })
                    } else {
                        Swal.fire({
                            position: 'center',
                            // icon: 'error',
                            title: `No has agregado un comentario`,
                            showConfirmButton: false,
                            timer: 1500
                        })
                    }
                } else {
                    Swal.fire({
                        position: 'center',
                        // icon: 'error',
                        title: `Debes estar logueado para comentar`,
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            }
        },
        computed: {
        },
    }).mount("#app")
}, 1000)